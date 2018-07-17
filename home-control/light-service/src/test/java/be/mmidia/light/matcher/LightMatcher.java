package be.mmidia.light.matcher;

import be.mmidia.light.model.Light;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class LightMatcher {
    public static Matcher<Light> lightMatcher(final Light expectedLight) {
        return new TypeSafeMatcher<Light>() {

            @Override
            public void describeTo(final Description description) {
                createDescription(expectedLight, description);
            }

            @Override
            protected void describeMismatchSafely(final Light light, final Description mismatchDescription) {
                mismatchDescription.appendText("was ");
                createDescription(light, mismatchDescription);
            }

            private Description createDescription(final Light light, final Description description){
                Description desc = description.appendText("Light with id ")
                        .appendValue(light.getId())
                        .appendText(", name ")
                        .appendValue(light.getName())
                        .appendText(", inUseSince ")
                        .appendValue(light.getInUseSince())
                        .appendText(", state ")
                        .appendValue(light.getState())
                        .appendText(" and members ");
                for(Membership member: light.getMemberships()){
                    desc.appendText("");
                }
                return desc;
            }

            @Override
            protected boolean matchesSafely(final Light receivedLight) {
                return receivedLight.getId() == expectedLight.getId()
                        && receivedLight.getName().equals(expectedLight.getName())
                        && receivedLight.getInUseSince() == expectedLight.getInUseSince()
                        && receivedLight.getState() == expectedLight.getState();
                // Todo: add members
            }
        };
    }
}
