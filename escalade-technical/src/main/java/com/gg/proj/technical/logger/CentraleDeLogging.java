package com.gg.proj.technical.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CentraleDeLogging {
    private static final Logger logger = LogManager.getLogger();

    public void logDebug(String str){logger.debug(str);}
    public void logInfo(String str) {logger.info(str);}
    public void logWarn(String str){logger.warn(str);}
    public void logError(String str){logger.error(str);}
    public void logFatal(String str){logger.fatal(str);}

    public boolean isDebugEnabled(){return logger.isDebugEnabled();}
    public boolean isInfoEnabled(){return logger.isInfoEnabled();}
    public boolean isWarnEnabled(){return logger.isWarnEnabled();}
    public boolean isErrorEnabled(){return logger.isErrorEnabled();}
    public boolean isFatalEnabled(){return logger.isFatalEnabled();}

}
