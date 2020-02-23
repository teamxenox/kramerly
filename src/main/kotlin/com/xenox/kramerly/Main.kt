package com.xenox.kramerly

import org.w3c.dom.*
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {

    val htmlPage = document.getElementsByTagName("html")[0] as Element

    val config = MutationObserverInit(
            childList = true,
            subtree = true,
            attributes = true
    )

    val observer = MutationObserver { arrayOfMutationRecords: Array<MutationRecord>, _: MutationObserver ->
        for (mutation in arrayOfMutationRecords) {

            if (mutation.type == "childList") {

                blockClick("span._33x6N") {
                    onClickBlocked()
                }

                blockClick("div._1QK5F") {
                    onClickBlocked()
                }
            }
        }
    }

    observer.observe(htmlPage, config)
    println("Observing page...")
}

fun onClickBlocked() {
    window.alert("Noo, baby.. you've to type it! 😜")
}

fun blockClick(selector: String, callback: () -> Unit) {
    val element = document.querySelector(selector)

    if (element != null) {
        println("Removed clicked from $selector")
    }
    element?.addEventListener("click", { event ->
        event.stopPropagation()
        callback()
    })
}
