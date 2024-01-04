package com.shivam.learn.designingjavaapi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import static com.shivam.learn.designingjavaapi.LoanFileReader.withFile;

/**
 * @author sksingh created on 28/08/23
 */
public class Test {

    // Using the weakest possible type in parameters
    public String concatenate(Iterable<String> strings) {
        final StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }

        return sb.toString();
    }

    // Return more generic type ( if accepted by the client )
    // Gives better flexibility in future
    public Collection<String> getAddresses(Person person) {
        Set<String> addresses = new HashSet<>();
        addresses.add(person.getAddress());
        for (Person sibling : person.getSiblings()) {
            addresses.add(sibling.getAddress());
        }

        return addresses;
    }

    public byte[] readFile(String filename) throws IOException {
        return withFile(filename, file -> {
            final byte[] buffer = new byte[4096];
            final ByteArrayOutputStream out = new ByteArrayOutputStream(buffer.length);

            int n;
            while ((n = file.read(buffer)) > 0) {
                out.write(buffer, 0, n);
            }

            return out.toByteArray();
        });
    }

    class EventProducer {

        public void registerBefore(Consumer<String> before) {
            // ignore
        }

        public void registerAfter(Consumer<String> after) {
            // ignore
        }
    }
}
