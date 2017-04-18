package edu.hawaii.its.groupings.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.holiday.configuration.SpringBootWebApplication;
import edu.internet2.middleware.grouperClient.ws.beans.WsSubjectLookup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class GroupingsServiceTest {

    @Autowired
    private GroupingsService groupingsService;

    @Test
    public void construction() {
        assertNotNull(groupingsService);
    }

    @Test
    public void makeWsSubjectLookup() {
        GroupingsService groupingsService = new GroupingsServiceImpl();
        final String username = "someuser";
        WsSubjectLookup lookup = groupingsService.makeWsSubjectLookup(username);
        assertNotNull(lookup);
        assertThat(lookup.getSubjectIdentifier(), equalTo(username));
        assertThat(lookup.getSubjectId(), equalTo(null));
        assertThat(lookup.getSubjectSourceId(), equalTo(null));
    }

}