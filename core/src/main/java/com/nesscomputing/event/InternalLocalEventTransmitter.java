/**
 * Copyright (C) 2012 Ness Computing, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nesscomputing.event;

import javax.annotation.Nonnull;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Direct transmitter that sends an event back into the local event system.
 */
@Singleton
class InternalLocalEventTransmitter implements NessEventTransmitter
{
    private final InternalEventDispatcher eventDispatcher;

    @Inject
    InternalLocalEventTransmitter(final InternalEventDispatcher eventDispatcher)
    {
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public void transmit(@Nonnull final NessEvent event)
    {
        eventDispatcher.dispatch(event);
    }
}