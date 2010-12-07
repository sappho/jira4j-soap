package uk.org.sappho.jira4j.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import uk.org.sappho.jira.rpc.soap.client.GetParent;
import uk.org.sappho.jira.rpc.soap.client.GetParentServiceLocator;

public class GetParentService {

    private final GetParent service;
    private final String token;

    public GetParentService(String url, String username, String password) throws MalformedURLException,
            ServiceException, RemoteException {

        service = new GetParentServiceLocator().getSapphoGetparentV1(new URL(url
                + "/rpc/soap/sappho-getparent-v1"));
        token = service.login(username, password);
    }

    public String getParent(String issueKey) throws RemoteException {

        return service.getParentKey(token, issueKey);
    }
}
