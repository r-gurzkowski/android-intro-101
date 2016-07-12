package com.intro.android.repository;

import com.intro.android.repository.adapter.NasaRoverRestAdapter;
import com.intro.android.repository.model.RoverData;
import com.intro.android.repository.model.RoverPhoto;

import org.junit.Test;

import rx.observers.TestSubscriber;

import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.Mockito.mock;

public class NasaRepositoryTest {

    NasaRoverRestAdapter restAdapterMock = mock(NasaRoverRestAdapter.class);
    NasaRepository nasaRepository = null;
    TestSubscriber testSubscriber = new TestSubscriber();

    @Test
    public void shouldReturnPhotoStream() {
        // given
        RoverPhoto expectedPhoto = new RoverPhoto("someUrl", "someDate");
        RoverData roverData = new RoverData(newArrayList(expectedPhoto));

        // when

        // then
    }
}