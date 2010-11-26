package uk.org.sappho.jira4j.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.atlassian.jira.rpc.soap.client.JiraSoapServiceServiceLocator;

public class JiraSoapService {

    protected final com.atlassian.jira.rpc.soap.client.JiraSoapService service;
    protected final String token;

    public JiraSoapService(String url, String username, String password) throws MalformedURLException,
            ServiceException, RemoteException {

        service = new JiraSoapServiceServiceLocator().getJirasoapserviceV2(new URL(url
                + "/rpc/soap/jirasoapservice-v2"));
        token = service.login(username, password);
    }

    public com.atlassian.jira.rpc.soap.client.JiraSoapService getService() {

        return service;
    }

    public String getToken() {

        return token;
    }
}
