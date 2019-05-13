/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mozilla.components.browser.icons.extension

import mozilla.components.browser.session.Session
import mozilla.components.browser.session.SessionManager
import mozilla.components.support.test.mock
import org.junit.Test
import org.mockito.Mockito.never
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify

class AllSessionsObserverTest {
    @Test
    fun `Observer will be registered on all already existing Sessions`() {
        val session1: Session = mock()
        val session2: Session = mock()

        val sessionManager = SessionManager(engine = mock()).apply {
            add(session1)
            add(session2)
        }

        val observer: Session.Observer = mock()

        AllSessionsObserver.register(sessionManager, observer)

        verify(session1).register(observer)
        verify(session2).register(observer)
    }

    @Test
    fun `Observer will be registered on added Sessions`() {
        val sessionManager = SessionManager(engine = mock())

        val observer: Session.Observer = mock()

        AllSessionsObserver.register(sessionManager, observer)

        val session1: Session = mock()
        val session2: Session = mock()

        sessionManager.add(session1)
        sessionManager.add(session2)

        verify(session1).register(observer)
        verify(session2).register(observer)
    }

    @Test
    fun `Observer will be unregistered if Session gets removed`() {
        val session1: Session = spy(Session("https://www.mozilla.org"))
        val session2: Session = mock()

        val sessionManager = SessionManager(engine = mock()).apply {
            add(session1)
            add(session2)
        }

        val observer: Session.Observer = mock()

        AllSessionsObserver.register(sessionManager, observer)

        sessionManager.remove(session1)

        verify(session1).register(observer)
        verify(session1).unregister(observer)

        verify(session2).register(observer)
        verify(session2, never()).unregister(observer)
    }

    @Test
    fun `Observer gets registered when Sessions get restored`() {
        val sessionManager = SessionManager(engine = mock())

        val observer: Session.Observer = mock()
        AllSessionsObserver.register(sessionManager, observer)

        val session1: Session = mock()
        val session2: Session = mock()

        val snapshot = SessionManager.Snapshot(
            sessions = listOf(
                SessionManager.Snapshot.Item(session1),
                SessionManager.Snapshot.Item(session2)),
            selectedSessionIndex = 0)

        sessionManager.restore(snapshot)

        verify(session1).register(observer)
        verify(session2).register(observer)
    }

    @Test
    fun `Observer gets unregistered when all Sessions get removed`() {
        val session1: Session = spy(Session("https://www.mozilla.org"))
        val session2: Session = spy(Session("https://getpocket.com"))

        val sessionManager = SessionManager(engine = mock()).apply {
            add(session1)
            add(session2)
        }

        val observer: Session.Observer = mock()
        AllSessionsObserver.register(sessionManager, observer)

        verify(session1).register(observer)
        verify(session2).register(observer)

        sessionManager.removeSessions()

        verify(session1).unregister(observer)
        verify(session2).unregister(observer)
    }
}