package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.ColumnSplicing;
import org.flys.cg.util.StringUtil;

/**
 * 基于模板的service生成器
 *
 * @author feifei.li
 */
public class BasedServiceImplGenerator extends AbstractGenerator implements Generator {

    public static final String mapper_full_name = "&mapper-full-name&";
    public static final String model_full_name = "&model_full-name&";
    public static final String service_full_name = "&service-full-name&";
    public static final String service_impl_name = "&service-impl-name&";
    public static final String service_name = "&service-name&";
    public static final String mapper_name = "&mapper-name&";
    public static final String model_name = "&model-name&";
    public static final String primaryKey_type = "&primaryKey-type&";
    public static final String primary_key = "&primaryKey&";
    public static final String primaryKey_get_method = "&primaryKey-get-method&";
    public static final String SERVICE_IMPL_PACKAGE = "&service-impl-package&";


    public BasedServiceImplGenerator(String packageName) {
        super(packageName);
    }

    @Override
    public Product doGenerate(MetaTable metaTable) {
        this.layer = "service.impl";
        String resource = this.loadResource("ServiceImpl.template");
        String className = current.getServiceClassName() + "Impl";
        String packageName = context.getPackageRoot() + SPOT + layer;
        String fullClassName = packageName + SPOT + className;
        String primaryKeyType = current.getPrimaryKeyType();
        String primaryKey = current.getPrimaryKey();
        String keyGetMethod = "get" + StringUtil.acronymUpperCase(ColumnSplicing.convertColumnToField(primaryKey));
        resource = resource.replaceAll(mapper_full_name, current.getFullMapperClassName())
                .replaceAll(model_full_name, current.getFullModelClassName())
                .replaceAll(service_full_name, current.getFullServiceClassName())
                .replaceAll(service_impl_name, className)
                .replaceAll(service_name, current.getServiceClassName())
                .replaceAll(mapper_name, current.getMapperClassName())
                .replaceAll(model_name, current.getModelClassName())
                .replaceAll(primaryKey_type, primaryKeyType)
                .replaceAll(primary_key, primaryKey)
                .replaceAll(primaryKey_get_method, keyGetMethod)
                .replaceAll(SERVICE_IMPL_PACKAGE, packageName);

        current.setServiceImplClassName(className);
        current.setFullServiceImplClassName(fullClassName);
        return new Product(className + SPOT + "java", resource);
    }
}
