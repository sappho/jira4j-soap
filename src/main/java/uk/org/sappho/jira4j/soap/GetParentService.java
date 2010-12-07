package uk.org.sappho.jira4j.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import uk.org.sappho.jira.rpc.soap.client.GetParent;
import uk.org.sappho.jira.rpc.soap.client.GetParentServiceLocator;

public class GetParentService {

    private final GetParent service;

    public GetParentService(String url) throws MalformedURLException, ServiceException {

        service = new GetParentServiceLocator().getSapphoGetparentV1(new URL(url
                + "/rpc/soap/sappho-getparent-v1"));
    }

    public String getParent(String issueKey) throws RemoteException {

        return service.getParentKey(issueKey);
    }
}
