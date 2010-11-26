package uk.org.sappho.jira4j.soap;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.junit.Test;

import com.atlassian.jira.rpc.soap.client.RemoteAuthenticationException;

public class JiraSoapServiceTest {

    @Test(expected = RemoteAuthenticationException.class)
    public void testBadLogin() throws MalformedURLException, RemoteException, ServiceException {

        new JiraSoapService("http://jira.atlassian.com", "sappho-test-random-v4HCD7h9JM", "2Gj8M29XrW");
    }

    @Test(expected = AxisFault.class)
    public void testUnknownHost() throws MalformedURLException, RemoteException, ServiceException {

        new JiraSoapService("http://jira9876.atlassian.com", "sappho-test-random-v4HCD7h9JM", "2Gj8M29XrW");
    }

    @Test(expected = MalformedURLException.class)
    public void testBadURL() throws MalformedURLException, RemoteException, ServiceException {

        new JiraSoapService("xxx://jira.atlassian.com", "sappho-test-random-v4HCD7h9JM", "2Gj8M29XrW");
    }
}
