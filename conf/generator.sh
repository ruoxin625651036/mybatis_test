#!/bin/bash

# 在添加db.properties的时候，发现一直找不到properties中的resource文件，后来发现是因为classpath没有添加当前路径导致的
java -cp .:mybatis-generator-core-1.3.5.jar org.mybatis.generator.api.ShellRunner -configfile mybatisConfig.xml -overwrite