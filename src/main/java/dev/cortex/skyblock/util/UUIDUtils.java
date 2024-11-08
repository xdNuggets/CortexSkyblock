package dev.cortex.skyblock.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Utility class for generating UUIDs (Universally Unique Identifiers).
 * This class includes a method to generate a time-based UUID (UUIDv1).
 *
 * <p>UUID version 1 is based on the system timestamp (measured in 100-nanosecond intervals
 * since the UUID epoch on 10 October 1582) and incorporates the system's MAC address (or
 * a random 48-bit value if the MAC address is unavailable) as the node identifier.
 * The method also ensures that UUIDs generated within the same timestamp interval are unique
 * by utilizing a clock sequence. The UUIDs will rollover in 3400 A.D</p>
 *
 * <p>Copyright 2022, Simon Morari. All Rights Reserved.</p>
 *
 * @version 1.1
 */
public class UUIDUtils {
    private static final long EPOCH_OFFSET = 122192928000000000L; // 00:00:00.00 UTC, 10 October 1582
    private static final Random RANDOM = new Random();
    private static final AtomicInteger SEQUENCE = new AtomicInteger(RANDOM.nextInt(Short.MAX_VALUE));
    private static final long NODE_ID;

    // Optimization: Generate the node identifier (MAC address or random value) once during class loading.
    // UUID.randomUUID(): 18ms (1,846 ns/op)
    // Unoptimized: 4202ms (420,267 ns/op) (per method node identifier generation)
    // Optimized: 0ms (40 ns/op) (~46x faster than UUID.randomUUID() & a higher entropy)
    static {
        long nodeId;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(ip);
            if (networkInterface != null) {
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    nodeId = 0;
                    for (int i = 0; i < mac.length; i++) {
                        nodeId |= ((long) mac[i] & 0xFF) << ((mac.length - 1 - i) * 8);
                    }
                } else {
                    nodeId = RANDOM.nextLong() & 0xFFFFFFFFFFFFL;
                }
            } else {
                nodeId = RANDOM.nextLong() & 0xFFFFFFFFFFFFL;
            }
        } catch (Exception e) {
            nodeId = RANDOM.nextLong() & 0xFFFFFFFFFFFFL;
        }
        NODE_ID = nodeId;
    }

    /**
     * Generates a time-based UUID (UUID version 1) based on the current timestamp, system node
     * (MAC address or random value), and a clock sequence to ensure uniqueness.
     *
     * <p>The generated UUID contains:</p>
     * <ul>
     *     <li>Timestamp: The number of 100-nanosecond intervals since 10 October 1582 (UUID epoch).</li>
     *     <li>Clock Sequence: A 14-bit sequence number to ensure uniqueness within the same timestamp.</li>
     *     <li>Node: A 48-bit identifier, typically derived from the system's MAC address or a random
     *     48-bit value if the MAC address is unavailable.</li>
     * </ul>
     *
     * @return A newly generated UUID of version 1.
     * @throws RuntimeException If the system fails to retrieve the MAC address and a fallback
     * random node generation fails (highly unlikely).
     * @see UUID
     */
    public static UUID getTimedUUID() {
        long timestamp = System.currentTimeMillis() * 10000 + EPOCH_OFFSET;
        int sequence = SEQUENCE.incrementAndGet() & 0x3FFF;

        long mostSigBits = (timestamp >> 32);
        mostSigBits |= (timestamp & 0xFFFFFFFFL) << 32;
        mostSigBits |= (0x1L << 12);

        long leastSigBits = (long) sequence << 48;
        leastSigBits |= NODE_ID;

        return new UUID(mostSigBits, leastSigBits);
    }
}