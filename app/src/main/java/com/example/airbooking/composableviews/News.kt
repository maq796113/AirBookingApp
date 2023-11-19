package com.example.airbooking.composableviews

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.airbooking.R
import com.google.relay.compose.CrossAxisAlignment
import com.google.relay.compose.EmptyPainter
import com.google.relay.compose.MainAxisAlignment
import com.google.relay.compose.RelayContainer
import com.google.relay.compose.RelayContainerArrangement
import com.google.relay.compose.RelayContainerScope
import com.google.relay.compose.RelayImage
import com.google.relay.compose.RelayText
import com.google.relay.compose.RelayVector
import com.google.relay.compose.tappable

// Design to select for News
enum class View {
    HeroItem,
    ArticleItem,
    AudioItem
}

/**
 * News card intended to display news item for a list.
 *
 *
 * This composable was generated from the UI Package 'news'.
 * Generated code; do not edit directly
 */
@Composable
fun News(
    modifier: Modifier = Modifier,
    view: View = View.HeroItem,
    thumbnail: Painter = EmptyPainter(),
    headline: String = "",
    author: String = "",
    date: String = "",
    onNewsCardTapped: () -> Unit = {},
    onMenuTapped: () -> Unit = {}
) {
    when (view) {
        View.HeroItem -> TopLevelViewHeroItem(
            onNewsCardTapped = onNewsCardTapped,
            modifier = modifier
        ) {
            ContentViewHeroItem(modifier = Modifier.rowWeight(1.0f)) {
                ThumbnailViewHeroItem(
                    thumbnail = thumbnail,
                    modifier = Modifier.rowWeight(1.0f)
                )
                TitleGroupViewHeroItem(modifier = Modifier.rowWeight(1.0f)) {
                    HeadlineViewHeroItem(
                        headline = headline,
                        modifier = Modifier.rowWeight(1.0f)
                    )
                    MetaViewHeroItem(modifier = Modifier.rowWeight(1.0f)) {
                        AuthorViewHeroItem(
                            author = author,
                            modifier = Modifier.rowWeight(1.0f)
                        )
                        DateViewHeroItem(
                            date = date,
                            modifier = Modifier.rowWeight(1.0f)
                        )
                    }
                }
            }
        }
        View.ArticleItem -> TopLevelViewArticleItem(
            onNewsCardTapped = onNewsCardTapped,
            modifier = modifier
        ) {
            ContentViewArticleItem(modifier = Modifier.rowWeight(1.0f)) {
                ThumbnailViewArticleItem(thumbnail = thumbnail)
                TitleGroupViewArticleItem(modifier = Modifier.rowWeight(1.0f)) {
                    HeadlineViewArticleItem(
                        headline = headline,
                        modifier = Modifier.rowWeight(1.0f)
                    )
                    MetaViewArticleItem(modifier = Modifier.rowWeight(1.0f)) {
                        AuthorViewArticleItem(author = author)
                        BulletPointViewArticleItem()
                        DateViewArticleItem(date = date)
                    }
                }
            }
        }
        View.AudioItem -> TopLevelViewAudioItem(
            onNewsCardTapped = onNewsCardTapped,
            modifier = modifier
        ) {
            ContentViewAudioItem(modifier = Modifier.rowWeight(1.0f)) {
                EpisodeViewAudioItem(modifier = Modifier.rowWeight(1.0f)) {
                    TitleGroupViewAudioItem(modifier = Modifier.rowWeight(1.0f)) {
                        HeadlineViewAudioItem(
                            headline = headline,
                            modifier = Modifier.rowWeight(1.0f)
                        )
                        AuthorViewAudioItem(
                            author = author,
                            modifier = Modifier.rowWeight(1.0f)
                        )
                    }
                    ThumbnailViewAudioItem(thumbnail = thumbnail)
                }
                MetaViewAudioItem(modifier = Modifier.rowWeight(1.0f)) {
                    DateViewAudioItem(date = date)
                    IconButtonViewAudioItem(onMenuTapped = onMenuTapped) {
                        IconAreaViewAudioItem {
                            MoreVertViewAudioItem(modifier = Modifier.rowWeight(1.0f).columnWeight(1.0f))
                        }
                    }
                }
            }
        }
    }
}

@Preview(widthDp = 354, heightDp = 312)
@Composable
private fun NewsViewHeroItemPreview() {
    MaterialTheme {
        RelayContainer {
            News(
                onNewsCardTapped = {},
                thumbnail = painterResource(R.drawable.news_thumbnail),
                headline = "Bamboos Are Getting Taller Day By Day",
                author = "The Bamboo Sagas",
                date = "October 31, 2023",
                onMenuTapped = {},
                view = View.HeroItem,
                modifier = Modifier.rowWeight(1.0f)
            )
        }
    }
}

@Preview(widthDp = 354, heightDp = 92)
@Composable
private fun NewsViewArticleItemPreview() {
    MaterialTheme {
        RelayContainer {
            News(
                onNewsCardTapped = {},
                thumbnail = painterResource(R.drawable.news_thumbnail1),
                headline = "The Wonderful Architectures of This Winter Season",
                author = "The Seasonal Sagas",
                date = "April 20, 2023",
                onMenuTapped = {},
                view = View.ArticleItem,
                modifier = Modifier.rowWeight(1.0f)
            )
        }
    }
}

@Preview(widthDp = 354, heightDp = 153)
@Composable
private fun NewsViewAudioItemPreview() {
    MaterialTheme {
        RelayContainer {
            News(
                onNewsCardTapped = {},
                thumbnail = painterResource(R.drawable.news_thumbnail2),
                headline = "The Wonderful Architectures of This Winter Season",
                author = "The Seasonal Sagas",
                date = "April 20, 2023",
                onMenuTapped = {},
                view = View.AudioItem,
                modifier = Modifier.rowWeight(1.0f)
            )
        }
    }
}

@Composable
fun ThumbnailViewHeroItem(
    thumbnail: Painter,
    modifier: Modifier = Modifier
) {
    RelayImage(
        image = thumbnail,
        radius = 12.0,
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxWidth(1.0f).requiredHeight(160.0.dp)
    )
}

@Composable
fun HeadlineViewHeroItem(
    headline: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = headline,
        fontSize = 22.0.sp,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.3620000319047407.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun AuthorViewHeroItem(
    author: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = author,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 253,
            green = 180,
            blue = 183
        ),
        height = 1.36181640625.em,
        textAlign = TextAlign.Left,
        overflow = TextOverflow.Ellipsis,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun DateViewHeroItem(
    date: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = date,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 253,
            green = 180,
            blue = 183
        ),
        height = 1.36181640625.em,
        textAlign = TextAlign.Left,
        overflow = TextOverflow.Ellipsis,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun MetaViewHeroItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 4.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun TitleGroupViewHeroItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun ContentViewHeroItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun TopLevelViewHeroItem(
    onNewsCardTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 108,
            green = 43,
            blue = 58
        ),
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(all = 16.0.dp),
        clipToParent = false,
        radius = 24.0,
        content = content,
        modifier = modifier.tappable(onTap = onNewsCardTapped).fillMaxWidth(1.0f)
    )
}

@Composable
fun ThumbnailViewArticleItem(
    thumbnail: Painter,
    modifier: Modifier = Modifier
) {
    RelayImage(
        image = thumbnail,
        radius = 12.0,
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(68.0.dp).requiredHeight(68.0.dp)
    )
}

@Composable
fun HeadlineViewArticleItem(
    headline: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = headline,
        fontSize = 16.0.sp,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.3619999885559082.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun AuthorViewArticleItem(
    author: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = author,
        fontSize = 13.0.sp,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 253,
            green = 180,
            blue = 183
        ),
        height = 1.36181640625.em,
        textAlign = TextAlign.Left,
        modifier = modifier.wrapContentHeight(
            align = Alignment.Bottom,
            unbounded = true
        )
    )
}

@Composable
fun BulletPointViewArticleItem(modifier: Modifier = Modifier) {
    RelayText(
        content = "•",
        fontSize = 13.0.sp,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 253,
            green = 180,
            blue = 183
        ),
        height = 1.36181640625.em,
        textAlign = TextAlign.Left,
        modifier = modifier.wrapContentHeight(
            align = Alignment.Bottom,
            unbounded = true
        )
    )
}

@Composable
fun DateViewArticleItem(
    date: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = date,
        fontSize = 13.0.sp,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 253,
            green = 180,
            blue = 183
        ),
        height = 1.36181640625.em,
        textAlign = TextAlign.Left,
        modifier = modifier.wrapContentHeight(
            align = Alignment.Bottom,
            unbounded = true
        )
    )
}

@Composable
fun MetaViewArticleItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 4.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun TitleGroupViewArticleItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 4.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun ContentViewArticleItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        itemSpacing = 12.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun TopLevelViewArticleItem(
    onNewsCardTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 108,
            green = 43,
            blue = 58
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 16.0.dp,
            top = 12.0.dp,
            end = 16.0.dp,
            bottom = 12.0.dp
        ),
        itemSpacing = 12.0,
        radius = 16.0,
        content = content,
        modifier = modifier.tappable(onTap = onNewsCardTapped).fillMaxWidth(1.0f)
    )
}

@Composable
fun HeadlineViewAudioItem(
    headline: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = headline,
        fontSize = 16.0.sp,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 255,
            green = 255,
            blue = 255
        ),
        height = 1.375.em,
        textAlign = TextAlign.Left,
        fontWeight = FontWeight(500.0.toInt()),
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun AuthorViewAudioItem(
    author: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = author,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 253,
            green = 180,
            blue = 183
        ),
        height = 1.36181640625.em,
        textAlign = TextAlign.Left,
        maxLines = -1,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun TitleGroupViewAudioItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        itemSpacing = 8.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun ThumbnailViewAudioItem(
    thumbnail: Painter,
    modifier: Modifier = Modifier
) {
    RelayImage(
        image = thumbnail,
        radius = 12.0,
        contentScale = ContentScale.Crop,
        modifier = modifier.requiredWidth(68.0.dp).requiredHeight(68.0.dp)
    )
}

@Composable
fun EpisodeViewAudioItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 16.0.dp,
            top = 0.0.dp,
            end = 16.0.dp,
            bottom = 0.0.dp
        ),
        itemSpacing = 12.0,
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun DateViewAudioItem(
    date: String,
    modifier: Modifier = Modifier
) {
    RelayText(
        content = date,
        fontFamily = notoSans,
        color = Color(
            alpha = 255,
            red = 253,
            green = 180,
            blue = 183
        ),
        height = 1.36181640625.em,
        textAlign = TextAlign.Left,
        modifier = modifier
    )
}

@Composable
fun MoreVertViewAudioItem(modifier: Modifier = Modifier) {
    RelayVector(
        vector = painterResource(R.drawable.news_more_vert),
        modifier = modifier.padding(
            paddingValues = PaddingValues(
                start = 10.0.dp,
                top = 4.0.dp,
                end = 10.0.dp,
                bottom = 4.0.dp
            )
        ).fillMaxWidth(1.0f).fillMaxHeight(1.0f)
    )
}

@Composable
fun IconAreaViewAudioItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        isStructured = false,
        clipToParent = false,
        content = content,
        modifier = modifier.requiredWidth(24.0.dp).requiredHeight(24.0.dp)
    )
}

@Composable
fun IconButtonViewAudioItem(
    onMenuTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(all = 8.0.dp),
        clipToParent = false,
        content = content,
        modifier = modifier.tappable(onTap = onMenuTapped)
    )
}

@Composable
fun MetaViewAudioItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.SpaceBetween,
        arrangement = RelayContainerArrangement.Row,
        padding = PaddingValues(
            start = 16.0.dp,
            top = 8.0.dp,
            end = 8.0.dp,
            bottom = 0.0.dp
        ),
        clipToParent = false,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun ContentViewAudioItem(
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        padding = PaddingValues(
            start = 0.0.dp,
            top = 16.0.dp,
            end = 0.0.dp,
            bottom = 10.0.dp
        ),
        itemSpacing = 8.0,
        content = content,
        modifier = modifier.fillMaxWidth(1.0f)
    )
}

@Composable
fun TopLevelViewAudioItem(
    onNewsCardTapped: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RelayContainerScope.() -> Unit
) {
    RelayContainer(
        backgroundColor = Color(
            alpha = 255,
            red = 108,
            green = 43,
            blue = 58
        ),
        mainAxisAlignment = MainAxisAlignment.Start,
        crossAxisAlignment = CrossAxisAlignment.Start,
        radius = 16.0,
        content = content,
        modifier = modifier.tappable(onTap = onNewsCardTapped).fillMaxWidth(1.0f)
    )
}
