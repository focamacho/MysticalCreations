package com.focamacho.mysticalcreations.config;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigMysticalCreations {

    private static TomlWriter writer = new TomlWriter.Builder()
                                            .indentValuesBy(2)
                                            .indentTablesBy(4)
                                            .build();
    private static Toml toml;
    private static SeedConfig seeds = new SeedConfig();
    public static List<String> allSeeds;
    public static boolean wrong = false;


    public static void initConfigs(){
        try {
            //Get the config file from configs folder
            File configFile = new File(FMLPaths.CONFIGDIR.get().toString(), "mysticalcreations-seeds.toml");

            //Create the config file and write comments
            if(!configFile.exists()) {
                configFile.createNewFile();
                seeds.mysticalcreations.put("_comment", new String[]{"Check the wiki to learn how to create your seeds! https://github.com/Focamacho/MysticalCreations/wiki"});
                seeds.mysticalcreations.put("seeds", new String[]{"cake;3;RESOURCE;INGOT;ROCK;45230E;null", "example;5;MOB;FACE;FLAME;FF0324;minecraft:diamond_block"});
                writer.write(seeds, configFile);
                toml = new Toml().read(configFile);
            }

            //Read the config file to TOML
            toml = new Toml().read(configFile);

            allSeeds = toml.getList("mysticalcreations.seeds");

        } catch(Exception e) {
            wrong = true;
            e.printStackTrace();
        }
    }

    static class SeedConfig{
        Map<String, String[]> mysticalcreations = new HashMap<String, String[]>();
    }

}