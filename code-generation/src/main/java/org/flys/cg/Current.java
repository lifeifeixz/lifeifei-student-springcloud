package org.flys.cg;

public class Current {
    public static final Current current = new Current();
    private String modelClassName;
    private String fullModelClassName;
    private String mapperClassName;
    private String fullMapperClassName;
    private String serviceClassName;
    private String fullServiceClassName;
    private String controllerClassName;
    private String fullControllerClassName;

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
}
