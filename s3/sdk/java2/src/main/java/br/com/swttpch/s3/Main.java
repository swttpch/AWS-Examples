package br.com.swttpch.s3;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

public class Main {
    public static void main(String[] args) {
        S3Client s3Client = DependencyFactory.s3Client();
        listAllBuckets(s3Client);
    }

    static void listAllBuckets(S3Client s3Client){
        System.out.println("Listando seus buckets do S3 na região " + s3Client.serviceClientConfiguration().region());
        try {
            ListBucketsResponse response = s3Client.listBuckets();

            if (response.buckets().isEmpty()) {
                System.out.println("Nenhum bucket encontrado.");
            } else {
                for (Bucket bucket : response.buckets()) {
                    System.out.println(" -> " + bucket.name());
                }
            }

        } catch (S3Exception e) {
            System.err.println("Erro ao listar buckets: " + e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}
