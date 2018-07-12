package be.mmidia.light.service.impl;

import be.mmidia.common.test.FrozenDateTime;
import be.mmidia.light.matcher.LightMatcher;
import be.mmidia.light.model.Light;
import be.mmidia.light.repository.LightRepository;
import be.mmidia.light.repository.LightUsageRepository;
import be.mmidia.light.service.LightService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javassist.NotFoundException;
import org.hamcrest.Matcher;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class LightServiceImplTest {
    @Mock
    private LightRepository lightRepositoryMock;
    @Mock
    private LightUsageRepository lightUsageRepositoryMock;

    @Captor
    private ArgumentCaptor<Light> captor;

    private LightService lightService;

    @Rule
    public FrozenDateTime frozenDateTime = new FrozenDateTime("2018-07-11T13:20:00");

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        lightService = new LightServiceImpl(lightRepositoryMock, lightUsageRepositoryMock);
    }

    @Test
    public void test_getAllLigths_happyFlow() throws Exception {
        List<Light> lights = createLights(3, null);
        Matcher<Light>[] expectedLightMatchers = createLightMatchers(lights);

        when(lightRepositoryMock.findAll()).thenReturn(lights);

        List<Light> resultLights = lightService.getAllLigths();

        assertThat(resultLights, hasSize(lights.size()));
        assertThat(resultLights, containsInAnyOrder(expectedLightMatchers));
    }

    @Test
    public void test_getLightById_happyFlow() throws Exception {
        List<Light> lights = createLights(3, null);

        when(lightRepositoryMock.findById(lights.get(0).getId())).thenReturn(Optional.of(lights.get(0)));

        Light result = lightService.getLightById(lights.get(0).getId());

        assertTrue(LightMatcher.lightMatcher(lights.get(0)).matches(result));
    }

    @Test
    public void test_getLightById_noresult() throws Exception {
        /*when(lightRepositoryMock.findById(4L)).thenReturn(null);

        try {
            lightService.getLightById(4L);
        } catch (Exception e) {
            assertTrue(e instanceof NotFoundException);
            assertEquals(e.getMessage(), "Light with id 4 not found");
        }*/
    }

    @Test
    public void createLight() throws Exception {
        Light light = new Light();
        light.setId(1L);
        light.setName("test");
        light.setState(Light.State.ON);
        light.setInUseSince(DateTime.now());

        lightService.createOrUpdateLight(light);

        verify(lightRepositoryMock, times(1)).save(captor.capture());
        assertTrue(LightMatcher.lightMatcher(light).matches(captor.getValue()));
    }

    @Test
    public void updateLight() throws Exception {
        Light light = new Light();
        light.setId(1L);
        light.setName("test");
        light.setState(Light.State.ON);
        light.setInUseSince(DateTime.now());

        when(lightRepositoryMock.findById(1L)).thenReturn(Optional.of(light));

        Light updated = new Light();
        updated.setId(1L);
        updated.setName("test2");
        updated.setState(Light.State.OFF);
        updated.setInUseSince(DateTime.now());

        lightService.createOrUpdateLight(updated);

        verify(lightRepositoryMock, times(1)).save(captor.capture());
        assertTrue(LightMatcher.lightMatcher(updated).matches(captor.getValue()));
    }

    @Test
    public void removeLightById() throws Exception {
    }

    /// TODO!!!
    @Test
    public void switchOffAllLights() throws Exception {
        List<Light> lights = createLights(3, Arrays.asList(Light.State.ON, Light.State.OFF, Light.State.ON));


    }

    // TODO!!!
    @Test
    public void switchLight() throws Exception {
    }

    // TODO!!!
    @Test
    public void getAllUsagesOfLight() throws Exception {
    }

    private List<Light> createLights(final int numberOfLights, final List<Light.State> states){
        List<Light> lights = new ArrayList<>();
        for(int i = 0; i < numberOfLights; i++){
            Light light = new Light();
            light.setId(i);
            light.setName("Name" + i);
            light.setInUseSince(DateTime.now().plusDays(i));
            if(states.isEmpty()) {
                light.setState(new Random().nextBoolean() ? Light.State.ON : Light.State.OFF);
            } else {
                light.setState(states.get(i));
            }
            lights.add(light);
        }

        return lights;
    }

    private Matcher<Light>[] createLightMatchers(final List<Light> lights) {
        Matcher<Light>[] expectedLightMatchers = new Matcher[lights.size()];
        for(int i = 0; i < lights.size(); i++){
            expectedLightMatchers[i] = LightMatcher.lightMatcher(lights.get(i));
        }

        return expectedLightMatchers;
    }
}