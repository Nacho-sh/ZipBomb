import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class ResourceLoader {
	
	public static ResourceLoader rl = new ResourceLoader();
	
	public static Image getImage(String fileName) {
		return Toolkit.getDefaultToolkit().getImage(rl.getClass().getResource("images/" + fileName));
	}
	
	static public String ExportResource(String resourceName) throws Exception {
        InputStream stream = null;
        OutputStream resStreamOut = null;
        String jarFolder;
        try {
            stream = ResourceLoader.class.getResourceAsStream(resourceName);
            if(stream == null) {
                throw new Exception("Cannot get resource \"" + resourceName + "\" from Jar file.");
            }

            int readBytes;
            byte[] buffer = new byte[4096];
            jarFolder = new File(ResourceLoader.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile().getPath().replace('\\', '/');
            resStreamOut = new FileOutputStream(resourceName);
            while ((readBytes = stream.read(buffer)) > 0) {
                resStreamOut.write(buffer, 0, readBytes);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
        	try {
            resStreamOut.close();
        	}catch (java.lang.NullPointerException ex) {
        }
        }

        return jarFolder + resourceName;
    }
}
