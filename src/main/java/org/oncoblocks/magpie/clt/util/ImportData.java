package org.oncoblocks.magpie.clt.util;

import org.oncoblocks.magpie.clt.config.ApplicationConfig;
import org.oncoblocks.magpie.clt.config.CltConfiguration;
import org.oncoblocks.magpie.clt.scripts.CnvDataLoader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportData {
    public static void main(String args[]) throws Exception{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
						ApplicationConfig.class, CltConfiguration.class);
        CnvDataLoader dataLoader = ctx.getBean(CnvDataLoader.class);
        dataLoader.loadCnvData();
    }
}
