package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
public class ContactControllerTest {

    @Mock
    private ContactService contactService;

    @InjectMocks
    private ContactController contactController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();
    }

    @Test
    public void testShowContacts() throws Exception {
        //Given
        List<ContactModel> contacts = new ArrayList<>();
        Mockito.when(contactService.listAllContacts()).thenReturn(contacts);

        //When
        mockMvc.perform(get("/contacts/showcontacts"))
                .andExpect(status().isOk())
                .andExpect(view().name("contacts"))
                .andExpect(model().attribute("contacts", Matchers.equalTo(contacts)));
    }

    @Test
    public void testRemoveContact() throws Exception {
        //Given
        Integer expectedId = 12;

        ArgumentCaptor<Integer> contactServiceArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

        //When
        mockMvc.perform(get("/contacts/removecontact").param("id", String.valueOf(expectedId)))
                .andExpect(status().isOk())
                .andExpect(view().name("contacts"));

        //Then
        Mockito.verify(contactService).removeContact(contactServiceArgumentCaptor.capture());
        Assert.assertEquals(expectedId, contactServiceArgumentCaptor.getValue());

    }
}