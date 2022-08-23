package org.example.auth;

import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;

import javax.security.auth.message.AuthException;
import javax.security.auth.message.MessageInfo;
import javax.security.auth.message.config.ServerAuthConfig;
import javax.security.auth.message.config.ServerAuthContext;
import javax.security.auth.message.module.ServerAuthModule;

/**
 * This class functions as a kind of factory for {@link ServerAuthContext}
 * instances, which are delegates for the actual {@link ServerAuthModule} (SAM)
 * that we're after.
 */
public class TestServerAuthConfig implements ServerAuthConfig
{
    private final String layer;
    private final String appContext;
    private final CallbackHandler handler;
    private final Map<String, String> providerProperties;

    public TestServerAuthConfig(String layer, String appContext, CallbackHandler handler, Map<String, String> providerProperties)
    {
        this.layer = layer;
        this.appContext = appContext;
        this.handler = handler;
        this.providerProperties = providerProperties;
    }

    /**
     * WebLogic 12c, JBoss EAP 6 and GlassFish 3.1.2.2 call this only once per
     * request, Geronimo V3 calls this before sam.validateRequest and again
     * before sam.secureRequest in the same request.
     */
    @Override
    public ServerAuthContext getAuthContext(String authContextID, Subject serviceSubject, Map properties) throws AuthException
    {
        return new TestServerAuthContext(handler);
    }

    @Override
    public String getMessageLayer()
    {
        return layer;
    }

    @Override
    public String getAuthContextID(MessageInfo messageInfo)
    {
        return appContext;
    }

    @Override
    public String getAppContext()
    {
        return appContext;
    }

    @Override
    public void refresh()
    {
    }

    @Override
    public boolean isProtected()
    {
        return false;
    }

    public Map<String, String> getProviderProperties()
    {
        return providerProperties;
    }
}