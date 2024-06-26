package ru.mirea.task12;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class FileHasher {
	@Value("${source:#{null}}")
	private String sourceFilename;
	@Value("${target}")
	private String targetFilename;

	@PostConstruct
	public void hashFile() {
		try {
			File sourceFile = new File(sourceFilename);

			if (!sourceFile.exists()) {
				File targetFile = new File(targetFilename);
				try (FileOutputStream fos = new FileOutputStream(targetFile)) {
					fos.write("null".getBytes());
				}
				return;
			}

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			try (FileInputStream fis = new FileInputStream(sourceFile)) {
				byte[] buffer = new byte[8192];
				int length;
				while ((length = fis.read(buffer)) != -1) {
					md.update(buffer, 0, length);
				}
			}

			byte[] hashBytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (byte b: hashBytes) {
				sb.append(String.format("%02x", b));
			}

			File targetFile = new File(targetFilename);
			try (FileOutputStream fos = new FileOutputStream(targetFile)) {
				fos.write(sb.toString().getBytes());
			}

			sourceFile.delete();
		}
		catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	@PreDestroy
	public void cleanUp() {
		File sourceFile = new File(sourceFilename);
		if (sourceFile.exists()) {
			sourceFile.delete();
		}
	}
}
