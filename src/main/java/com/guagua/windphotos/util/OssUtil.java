package com.guagua.windphotos.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProvider;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class OssUtil {

    /**
     * 人像
     */
    public static String PORTRAIT = "portrait/";

    /**
     * 产品
     */
    public static String PRODUCT = "product/";

    /**
     * 风景
     */
    public static String LANDSCAPE = "landscape/";

    private static final String ENDPOINT = "https://oss-cn-chengdu.aliyuncs.com";
    private static final String BUCKET_NAME = "wind-photos";
    private static final String ACCESS_KEY_ID = "ACCESS_KEY_ID";
    private static final String ACCESS_KEY_SECRET = "ACCESS_KEY_SECRET";

    private static final CredentialsProvider credentialsProvider = new DefaultCredentialProvider(ACCESS_KEY_ID, ACCESS_KEY_SECRET);

    public static OSS getOssClient() {
        return new OSSClientBuilder().build(ENDPOINT, credentialsProvider);
    }

    public static List<String> listDir(String prefix) {
        ListObjectsV2Request listObjectsRequest = new ListObjectsV2Request(BUCKET_NAME, prefix);
        listObjectsRequest.setDelimiter("/");

        OSS ossClient = getOssClient();
        ListObjectsV2Result objects = ossClient.listObjectsV2(listObjectsRequest);
        List<String> list = objects.getCommonPrefixes();
        ossClient.shutdown();
        return list;
    }

    public static List<OSSObjectSummary> listObject(String prefix) {
        ListObjectsV2Request listObjectsRequest = new ListObjectsV2Request(BUCKET_NAME, prefix);
        listObjectsRequest.setDelimiter("/");

        OSS ossClient = getOssClient();
        ListObjectsV2Result objects = ossClient.listObjectsV2(listObjectsRequest);
        List<OSSObjectSummary> list = objects.getObjectSummaries();
        ossClient.shutdown();

        list = list.stream().filter(item -> item.getSize() > 0).collect(Collectors.toList());

        return list;
    }

    public static String generateUrl(String objectPath) {
        OSS ossClient = getOssClient();

        Date expiration = new Date(new Date().getTime() + 3600 * 1000L);
        return ossClient.generatePresignedUrl(BUCKET_NAME, objectPath, expiration).toString();
    }

    public static List<String> generateUrl(List<String> objectPaths) {
        OSS ossClient = getOssClient();

        Date expiration = new Date(new Date().getTime() + 3600 * 1000L);

        return objectPaths.stream().map(objectPath -> ossClient.generatePresignedUrl(BUCKET_NAME, objectPath, expiration).toString()).collect(Collectors.toList());
    }

    public static List<String> getObjectsUrl(String objectPath) {
        List<OSSObjectSummary> ossObjectSummaries = listObject(objectPath);
        return ossObjectSummaries.stream().map(OSSObjectSummary::getKey).map(OssUtil::generateUrl).toList();
    }

    public static void main(String[] args) {
        List<String> list = listDir(PRODUCT);

        for (String dir : list) {
            List<OSSObjectSummary> ossObjectSummaries = listObject(dir);

            List<String> collect = ossObjectSummaries.stream().map(OSSObjectSummary::getKey).map(OssUtil::generateUrl).collect(Collectors.toList());
            System.out.println(1);
        }
    }
}
