package com.intro.android.repository;

import com.intro.android.repository.adapter.NasaRoverRestAdapter;
import com.intro.android.repository.model.RoverData;
import com.intro.android.repository.model.RoverPhoto;

import org.junit.Test;

import rx.observers.TestSubscriber;

import static com.google.common.collect.Lists.newArrayList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static rx.Observable.just;

public class NasaRepositoryTest {

    NasaRoverRestAdapter restAdapterMock = mock(NasaRoverRestAdapter.class);
    NasaRepository nasaRepository = new NasaRepository(restAdapterMock);
    TestSubscriber testSubscriber = new TestSubscriber();

    @Test
    public void shouldReturnSinglePhotoFromApi() {
        // given
        RoverPhoto expectedPhoto = new RoverPhoto("someUrl", "someDate");
        RoverData roverData = new RoverData(newArrayList(expectedPhoto));
        given(restAdapterMock.rover(anyString(), anyInt(), anyString(), anyString()))
                .willReturn(just(roverData));

        // when
        nasaRepository.downloadCuriosityPhoto().subscribe(testSubscriber);

        // then
        testSubscriber.assertReceivedOnNext(newArrayList(expectedPhoto));
    }
}