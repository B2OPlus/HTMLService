package org.b2oplus.htmlservice;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

/**
 * Created by abuabdul
 */
public class EncryptorHelper {

    public static final String ENCRYPT_ALGORITHM = "PBEWITHMD5ANDDES";
    public static final String ENCRYPT_SALT_ENV = "APP_ENCRYPTION_PASSWORD";

    public static void main(String[] args) {
        StringEncryptor encryptor = new EncryptorHelper.Encryptor().stringEncryptor();
        System.out.println("email.host -> " + encryptor.encrypt(args[0]));
        System.out.println("email.port -> " + encryptor.encrypt(args[1]));
        System.out.println("email.authentication -> " + encryptor.encrypt(args[2]));
        System.out.println("email.tls.enable -> " + encryptor.encrypt(args[3]));
        System.out.println("email.admin.username -> " + encryptor.encrypt(args[4]));
        System.out.println("email.admin.password -> " + encryptor.encrypt(args[5]));
        System.out.println("email.admin.recipient -> " + encryptor.encrypt(args[6]));
    }

    private static class Encryptor {

        public EnvironmentStringPBEConfig encConfig() {
            EnvironmentStringPBEConfig encConfig = new EnvironmentStringPBEConfig();
            encConfig.setAlgorithm(ENCRYPT_ALGORITHM);
            encConfig.setPasswordEnvName(ENCRYPT_SALT_ENV); //ENVIRONMENT VARIABLE
            return encConfig;
        }

        public StringEncryptor stringEncryptor() {
            StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
            stringEncryptor.setConfig(encConfig());
            return stringEncryptor;
        }
    }
}
