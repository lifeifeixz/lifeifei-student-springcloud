package org.flys.cg.meta;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feifei.li
 */
public class Current {
    public static final Current current = new Current();
    private Map<String, Object> memory = new HashMap<>();

    private String modelClassName;
    private String fullModelClassName;
    private String mapperClassName;
    private String fullMapperClassName;
    private String serviceClassName;
    private String fullServiceClassName;
    private String serviceImplClassName;
    private String fullServiceImplClassName;
    private String controllerClassName;
    private String fullControllerClassName;
    private String requestMapping;
    private String voClassName;
    private String fullVoClassName;
    private String saveVoClassName;
    private String fullSaveVoClassName;
    private String primaryKey;
    private String primaryKeyType;

    private Current() {
    }

    public String getMapperClassName() {
        return mapperClassName;
    }

    public void setMapperClassName(String mapperClassName) {
        this.mapperClassName = mapperClassName;
    }

    public String getFullMapperClassName() {
        return fullMapperClassName;
    }

    public void setFullMapperClassName(String fullMapperClassName) {
        this.fullMapperClassName = fullMapperClassName;
    }

    public String getModelClassName() {
        return modelClassName;
    }

    public void setModelClassName(String modelClassName) {
        this.modelClassName = modelClassName;
    }

    public String getFullModelClassName() {
        return fullModelClassName;
    }

    public void setFullModelClassName(String fullModelClassName) {
        this.fullModelClassName = fullModelClassName;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public void setServiceClassName(String serviceClassName) {
        this.serviceClassName = serviceClassName;
    }

    public String getFullServiceClassName() {
        return fullServiceClassName;
    }

    public void setFullServiceClassName(String fullServiceClassName) {
        this.fullServiceClassName = fullServiceClassName;
    }

    public String getControllerClassName() {
        return controllerClassName;
    }

    public void setControllerClassName(String controllerClassName) {
        this.controllerClassName = controllerClassName;
    }

    public String getFullControllerClassName() {
        return fullControllerClassName;
    }

    public void setFullControllerClassName(String fullControllerClassName) {
        this.fullControllerClassName = fullControllerClassName;
    }

    public String getRequestMapping() {
        return requestMapping;
    }

    public void setRequestMapping(String requestMapping) {
        this.requestMapping = requestMapping;
    }

    public String getVoClassName() {
        return voClassName;
    }

    public void setVoClassName(String voClassName) {
        this.voClassName = voClassName;
    }

    public String getFullVoClassName() {
        return fullVoClassName;
    }

    public void setFullVoClassName(String fullVoClassName) {
        this.fullVoClassName = fullVoClassName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getPrimaryKeyType() {
        return primaryKeyType;
    }

    public void setPrimaryKeyType(String primaryKeyType) {
        this.primaryKeyType = primaryKeyType;
    }

    public String getServiceImplClassName() {
        return serviceImplClassName;
    }

    public void setServiceImplClassName(String serviceImplClassName) {
        this.serviceImplClassName = serviceImplClassName;
    }

    public String getFullServiceImplClassName() {
        return fullServiceImplClassName;
    }

    public void setFullServiceImplClassName(String fullServiceImplClassName) {
        this.fullServiceImplClassName = fullServiceImplClassName;
    }

    public Object getData(String key) {
        return memory.get(key);
    }

    public void put(String key, Object v) {
        memory.put(key, v);
    }

    public static Current getCurrent() {
        return current;
    }

    public String getSaveVoClassName() {
        return saveVoClassName;
    }

    public void setSaveVoClassName(String saveVoClassName) {
        this.saveVoClassName = saveVoClassName;
    }

    public String getFullSaveVoClassName() {
        return fullSaveVoClassName;
    }

    public void setFullSaveVoClassName(String fullSaveVoClassName) {
        this.fullSaveVoClassName = fullSaveVoClassName;
    }
}
