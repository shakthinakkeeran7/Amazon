package com.amazon.managers;

import com.amazon.dataProvider.ConfigFileReader;
import com.amazon.dataProvider.JsonDataReader;

public class FileReaderManager {

	    private static FileReaderManager fileReaderManager = new FileReaderManager();
	    private static ConfigFileReader configFileReader;
	    private static JsonDataReader jsonDataReader;

	    private FileReaderManager() {
	    }

	    public static FileReaderManager getInstance( ) {
	        return fileReaderManager;
	    }

	    public ConfigFileReader getConfigReader() {
	        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	    }

	    public JsonDataReader getJsonReader(){
	        return (jsonDataReader == null) ? new JsonDataReader() : jsonDataReader;
	    }
	}