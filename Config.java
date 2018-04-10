package com.config;

import java.io.InputStreamReader;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Config {
	private static Config config = null;
	static {
		try (Reader reader = new InputStreamReader(Config.class.getResourceAsStream("/config.json"), "UTF-8")) {
			Gson gson = new GsonBuilder().create();
			config = gson.fromJson(reader, Config.class);
		} catch (Exception e) {
			System.out.println("Not able to read config file : " + e.getMessage());
			e.printStackTrace();
		}
	}

	private boolean allow_mongo_insertion;
	private int max_batch_size;
	private String hiveDatabaseName;
	private String hiveInsightsTableName;
	private String inputDatasetFileName;
	private String mlModelOutputPath;

	public boolean getAllow_mongo_insertion() {
		return this.allow_mongo_insertion;
	}

	public void setAllow_mongo_insertion(boolean allow_mongo_insertion) {
		this.allow_mongo_insertion = allow_mongo_insertion;
	}

	public String getMlModelOutputPath() {
		return mlModelOutputPath;
	}

	public void setMlModelOutputPath(String mlModelOutputPath) {
		this.mlModelOutputPath = mlModelOutputPath;
	}

	public String getInputDatasetFileName() {
		return inputDatasetFileName;
	}

	public void setInputDatasetFileName(String inputDatasetFileName) {
		this.inputDatasetFileName = inputDatasetFileName;
	}

	public int getMax_batch_size() {
		return this.max_batch_size;
	}

	public void setMax_batch_size(int max_batch_size) {
		this.max_batch_size = max_batch_size;
	}

	public String getHiveDatabaseName() {
		return this.hiveDatabaseName;
	}

	public void setHiveDatabaseName(String hiveDatabaseName) {
		this.hiveDatabaseName = hiveDatabaseName;
	}

	public String getHiveInsightsTableName() {
		return hiveInsightsTableName;
	}

	public void setHiveInsightsTableName(String hiveInsightsTableName) {
		this.hiveInsightsTableName = hiveInsightsTableName;
	}

	public static Config getConfig() {
		return config;

	}
	public static void main(String args[]) {
		System.out.println(getConfig().getAllow_mongo_insertion());
	}
}
