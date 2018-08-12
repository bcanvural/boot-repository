package dev.bcv.bootrepository;

import java.io.File;

import javax.jcr.RepositoryException;

public class RepoFactory {
    private static final String repoConfig = "/dev/bcv/bootrepository/repository-mysql.xml";

    public static BootRepository getHippoEnterpriseRepository() throws RepositoryException {
        final File tmpdir = new File(System.getProperty("java.io.tmpdir"));
        final File storage = new File(tmpdir, "storage");
        if (!storage.exists()) {
            storage.mkdir();
        }
        final String repoPath = storage.getAbsolutePath();
        return new BootRepository(repoPath, repoConfig);
    }
}
