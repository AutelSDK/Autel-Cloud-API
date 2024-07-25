package com.autel.service.storage.service;


import com.autel.great.mqtt.model.storage.StsCredentialsResponse;

public interface IStorageService {

    StsCredentialsResponse getSTSCredentials();

}
