package org.oncoblocks.magpie.clt.util;

import org.oncoblocks.magpie.clt.config.CltConfiguration;
import org.oncoblocks.magpie.clt.scripts.DataLoader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportData {
    public static void main(String args[]) throws Exception{
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(CltConfiguration.class);
        DataLoader dataLoader = ctx.getBean(DataLoader.class);
        dataLoader.loadCnvData();
    }
}
