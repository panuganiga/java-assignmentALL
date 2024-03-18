import java.io.*;
import java.util.ArrayList;
import java.util.List;

class VersionControlSystem {
    private byte[] baseVersion;
    private List<byte[]> deltas;

    public VersionControlSystem(byte[] baseVersion) {
        this.baseVersion = baseVersion;
        this.deltas = new ArrayList<>();
    }

    public void addDelta(byte[] delta) {
        deltas.add(delta);
    }

    public byte[] generateVersion(int versionIndex) {
        if (versionIndex < 0 || versionIndex >= deltas.size()) {
            throw new IllegalArgumentException("Invalid version index");
        }

        byte[] version = baseVersion.clone();
        for (int i = 0; i <= versionIndex; i++) {
            version = applyDelta(version, deltas.get(i));
        }

        return version;
    }

    private byte[] applyDelta(byte[] baseVersion, byte[] delta) {
        byte[] result = new byte[baseVersion.length];
        for (int i = 0; i < baseVersion.length; i++) {
            result[i] = (byte) (baseVersion[i] + delta[i]);
        }
        return result;
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(baseVersion);
            outputStream.writeObject(deltas);
        }
    }

    public static VersionControlSystem loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            byte[] baseVersion = (byte[]) inputStream.readObject();
            List<byte[]> deltas = (List<byte[]>) inputStream.readObject();
            VersionControlSystem vcs = new VersionControlSystem(baseVersion);
            vcs.deltas = deltas;
            return vcs;
        }
    }
}

