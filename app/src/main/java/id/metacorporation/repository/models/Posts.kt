package id.metacorporation.models

import com.google.gson.annotations.SerializedName
data class Posts(
    @SerializedName("author")
    val author: Int,
    @SerializedName("categories")
    val categories: List<Int>,
    @SerializedName("content")
    val content: Content,
    @SerializedName("date")
    val date: String,
    @SerializedName("excerpt")
    val excerpt: Excerpt,
    @SerializedName("featured_media")
    val featuredMedia: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("title")
    val title: Title,
    @SerializedName("yoast_head_json")
    val yoastHeadJson: YoastHeadJson
)

data class Content(
    @SerializedName("protected")
    val `protected`: Boolean,
    @SerializedName("rendered")
    val rendered: String
)

data class Excerpt(
    @SerializedName("protected")
    val `protected`: Boolean,
    @SerializedName("rendered")
    val rendered: String
)

data class Title(
    @SerializedName("rendered")
    val rendered: String
)

data class YoastHeadJson(
    @SerializedName("article_published_time")
    val articlePublishedTime: String,
    @SerializedName("og_description")
    val ogDescription: String,
    @SerializedName("og_image")
    val ogImage: List<OgImage>,
    @SerializedName("og_site_name")
    val ogSiteName: String,
    @SerializedName("og_title")
    val ogTitle: String,
    @SerializedName("og_url")
    val ogUrl: String,
    @SerializedName("robots")
    val robots: Robots,
    @SerializedName("title")
    val title: String,
    @SerializedName("twitter_card")
    val twitterCard: String,
    @SerializedName("twitter_misc")
    val twitterMisc: TwitterMisc
)

data class OgImage(
    @SerializedName("height")
    val height: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)

data class Robots(
    @SerializedName("follow")
    val follow: String,
    @SerializedName("index")
    val index: String,
    @SerializedName("max-image-preview")
    val maxImagePreview: String,
    @SerializedName("max-snippet")
    val maxSnippet: String,
    @SerializedName("max-video-preview")
    val maxVideoPreview: String
)

data class TwitterMisc(
    @SerializedName("Est. reading time")
    val estReadingTime: String,
    @SerializedName("Written by")
    val writtenBy: String
)