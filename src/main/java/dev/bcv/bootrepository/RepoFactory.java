package dev.bcv.bootrepository;

import java.io.File;
import java.util.UUID;

import javax.jcr.RepositoryException;

public class RepoFactory {
    private static final String repoConfig = "/dev/bcv/bootrepository/repository.xml";

    public static BootRepository getHippoEnterpriseRepository() throws RepositoryException {
        final File tmpdir = new File(System.getProperty("java.io.tmpdir"));
        final File storage = new File(tmpdir, "repository-" + UUID.randomUUID().toString());
        if (!storage.exists()) {
            storage.mkdir();
        }
        final String repoPath = storage.getAbsolutePath();
        return new BootRepository(repoPath, repoConfig);
    }
}
