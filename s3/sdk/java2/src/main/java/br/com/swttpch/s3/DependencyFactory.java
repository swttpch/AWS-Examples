package br.com.swttpch.s3;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URLConnection;

public class DependencyFactory {
    private DependencyFactory(){}

    public static S3Client s3Client(){
        return S3Client.builder()
                .region(Region.US_EAST_1)
                .build();
    }
}
