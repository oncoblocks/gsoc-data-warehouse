package org.oncoblocks.magpie.clt.scripts;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.oncoblocks.magpie.rest.service.CopyNumberGeneCentricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CnvDataLoader {

    @Autowired
    CopyNumberGeneCentricService copyNumberGeneCentricService;
	
    private static final Log log = LogFactory.getLog(CnvDataLoader.class);

    public void loadCnvData() throws Exception{


    }

}
