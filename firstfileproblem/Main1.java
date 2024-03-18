import java.io.IOException;

public class Main1 {
    public static void main(String[] args) {
        try {
            // Create a base version of the file
            byte[] baseVersion = "Base version of the file".getBytes();

            // Initialize version control system with the base version
            VersionControlSystem vcs = new VersionControlSystem(baseVersion);

            // Add some versions (deltas) to the system
            byte[] delta1 = new byte[baseVersion.length]; // Create delta array with the same length as base version
            delta1[0] = 1; // Example: Change the first byte
            vcs.addDelta(delta1);

            byte[] delta2 = new byte[baseVersion.length]; // Create delta array with the same length as base version
            delta2[0] = 2; // Example: Change the first byte
            vcs.addDelta(delta2);

            byte[] delta3 = new byte[baseVersion.length]; // Create delta array with the same length as base version
            delta3[0] = 3; // Example: Change the first byte
            vcs.addDelta(delta3);

            // Generate any version
            int versionIndex = 2; // Index of the version to generate
            byte[] generatedVersion = vcs.generateVersion(versionIndex);

            // Output the generated version
            System.out.println(new String(generatedVersion));

            // Save the version control system to a file
            vcs.saveToFile("version_control.dat");

            // Load the version control system from the file
            VersionControlSystem loadedVCS = VersionControlSystem.loadFromFile("version_control.dat");

            // Generate version from loaded VCS
            byte[] generatedVersionFromLoadedVCS = loadedVCS.generateVersion(versionIndex);

            // Output the generated version from loaded VCS
            System.out.println(new String(generatedVersionFromLoadedVCS));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
