import java.io.*;

public class InsecureDeserialization {
    public static void main(String[] args) throws Exception {
        // BAD: Deserializing data from an untrusted source
        byte[] serializedData = getUntrustedData(); // Imagine this comes from a network or cookie
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(serializedData));
        ois.readObject(); // An attacker can supply a malicious payload that triggers RCE here.
        ois.close();
    }

    private static byte[] getUntrustedData() {
        // Placeholder for receiving data from an untrusted source
        // In a real attack, this would be a crafted byte stream
        return new byte[0]; 
    }
}
