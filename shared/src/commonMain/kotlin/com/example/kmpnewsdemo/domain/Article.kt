package com.example.kmpnewsdemo.domain

data class Article(
    val title: String,
    val description: String,
    val imageURL: String,
    val publishDate: String,
    val isFavorite: Boolean = false
)

val fakeArticles = listOf(
    Article(
        title = "Stock market today: Live updates - CNBC",
        description = "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
        imageURL = "https://www.notebookcheck.net/fileadmin/Notebooks/News/_nc5/Tesla-Cybercab88.jpg",
        publishDate = "2023-11-09"
    ),
    Article(
        title = "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
        description = "Apple's smartphones rarely go on sale, but if you're looking to upgrade (or you're gift...",
        imageURL = "https://biztoc.com/cdn/995/og.png",
        publishDate = "2023-11-08"
    ),
    Article(
        title = "SpaceX Launch Success: New Satellite in Orbit",
        description = "SpaceX successfully launched another batch of Starlink satellites from Cape Canaveral.",
        imageURL = "https://media.thenextweb.com/2026/06/Odyssey-co-founders1.avif",
        publishDate = "2023-11-07"
    ),
    Article(
        title = "Global Climate Summit: New Agreements Reached",
        description = "World leaders have agreed on a new set of targets to reduce carbon emissions by 2030.",
        imageURL = "https://i0.wp.com/electrek.co/wp-content/uploads/sites/3/2026/06/Tesla-Supercharger-vacuum.jpeg?resize=1200%2C628&quality=82&strip=all&ssl=1",
        publishDate = "2023-11-06"
    ),
    Article(
        title = "AI Breakthrough: New Model Surpasses Human Performance",
        description = "Researchers have unveiled a new AI model that performs significantly better on logic tasks.",
        imageURL = "https://img.etimg.com/thumb/msid-131801046,width-1200,height-630,imgsize-23238,overlay-economictimes/articleshow.jpg",
        publishDate = "2023-11-05"
    ),
    Article(
        title = "Recipe of the Week: Perfect Homemade Pasta",
        description = "Learn how to make authentic Italian pasta from scratch with just three simple ingredients.",
        imageURL = "https://s.yimg.com/lo/mysterio/api/D5AA33946292EB5B1EA045550D35202B51F74C61AE0C74F9954C1F2A7A7747FF/subgraphmysterio/resizefill_w1200_h800;quality_80;format_webp/https:%2F%2Fd29szjachogqwa.cloudfront.net%2Fimages%2F2026-06%2F95dfe139-a50d-4327-9691-d54fb9806071",
        publishDate = "2023-11-04"
    ),
    Article(
        title = "Travel Guide: 10 Must-Visit Places in 2024",
        description = "From hidden beaches to vibrant cities, here are the top travel destinations for next year.",
        imageURL = "https://static.cryptobriefing.com/wp-content/uploads/2026/06/17081121/the-spacex-falcon-9-rocket-booster-is-seen-just-seconds-befo-59-800x420.jpeg",
        publishDate = "2023-11-03"
    )
)