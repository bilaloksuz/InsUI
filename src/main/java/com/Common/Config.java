package com.Common;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Config {
    private Map<String, String> data;
    private Map<String, String> gridConfiguration;
    public static Config config;


    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Map<String, String> getGridConfiguration() {
        return gridConfiguration;
    }

    public void setGridConfiguration(Map<String, String> gridConfiguration) {
        this.gridConfiguration = gridConfiguration;
    }

    public void setConfig(Config config) {
        Config.config = config;
    }

    public static Config getConfig() {
        return config;
    }

    public String getBaseUrl() {
        return data.get("BaseUrl");
    }
    public String getBrowser() {
        return data.get("Browser");
    }

    public String getInsiderLogoUrl() {
        return data.get("Logo");
    }

    public String getMoreText() {
        return data.get("MoreButtonText");
    }

    public String getCareerText() {
        return data.get("CareerText");
    }

    public String getFindJobButtonText() {
        return data.get("FindJobButtonText");
    }

    public String getQaJobButtonText() {
        return data.get("QaJobButtonText");
    }

    public String getQaJobTitle() {
        return data.get("QaJobTitle");
    }
    public String getDefaultLocation() {
        return data.get("DefaultLocation");
    }

    public String getGridUrl() {
        return gridConfiguration.get("gridURL");
    }

    public Config() {

    }

    public Config config(String env)
    {
        if(env.equals("") || env==null)
        {
            env="production";
        }
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Config config = null;
        try {
            config = mapper.readValue(new File(System.getProperty("user.dir") + "/Config-" + env + ".yaml"), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setConfig(config);
        setConfig(config);
        return config;
    }


}