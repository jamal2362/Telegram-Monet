package com.jamal2367.tgmonet.data.tgx

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import com.jamal2367.tgmonet.R
import com.google.android.material.color.MaterialColors
import com.google.android.material.elevation.SurfaceColors

object Generator {
  private const val backgrounds = "statusBar, circleButtonChatIcon, circleButtonOverlayIcon, headerButtonIcon, bubble_chatSeparator, bubbleOut_file, file, fileYellow, fileGreen, fileRed, unread, avatar_content, badgeFailedText, badgeMutedText, badgeText, bubble_chatBackground, bubble_messageCheckOutline, bubble_messageCheckOutlineNoWallpaper, bubbleOut_chatCorrectChosenFillingContent, bubbleOut_chatCorrectFillingContent, bubbleOut_chatNegativeFillingContent, bubbleOut_chatNeutralFillingContent, chatBackground, chatKeyboard, checkContent, circleButtonNegativeIcon, circleButtonNewChannelIcon, circleButtonNewChatIcon, circleButtonNewGroupIcon, circleButtonNewSecretIcon, circleButtonPositiveIcon, circleButtonRegularIcon, circleButtonThemeIcon, controlContent, drawer, filling, fillingPositiveContent, headerBackground, inlineContentActive, messageCorrectChosenFillingContent, messageCorrectFillingContent, messageNegativeLineContent, messageNeutralFillingContent, promoContent, sectionedScrollBarActiveContent, statusBarLegacy, background, chatSeparator, iv_preBlockBackground, passcode, separator, shareSeparator, snackbarUpdate"
  private const val backgrounds2 = "bubbleIn_background, bubble_date, bubble_date_noWallpaper"
  private const val primaryText = "attachText, bubble_buttonText, bubble_buttonText_noWallpaper, bubble_mediaOverlayText, bubble_mediaReplyText, bubble_mediaReplyText_noWallpaper, bubble_mediaTimeText, bubble_mediaTimeText_noWallpaper, bubble_overlayText, bubble_overlayText_noWallpaper, bubble_unreadText, bubble_unreadText_noWallpaper, bubbleIn_progress, bubbleOut_progress, drawerText, headerText, iv_pageTitle, iv_pullQuote, iv_text, iv_textCode, iv_textMarked, iv_textReference, messageSwipeContent, passcodeText, playerButton, snackbarUpdateText, statusBarContent, statusBarLegacyContent, text, textLight, tooltip_text, unreadText"
  private const val secondaryText = "background_textLight, headerBarCallMuted, inputInactive, iv_caption, iv_pageAuthor, iv_pageFooter, iv_pageSubtitle, textPlaceholder"
  private const val accents = "circleButtonChat, headerIcon, bubble_dateText, bubble_dateText_noWallpaper, bubbleOut_background, background_text, avatarArchive, avatarReplies, avatarReplies_big, avatarArchivePinned, avatarSavedMessages, avatarSavedMessages_big, badge, badgeMuted, bubbleIn_textLink, chatListAction, chatListMute, chatListVerify, chatSendButton, checkActive, circleButtonRegular, circleButtonTheme, controlActive, fillingPositive, headerButton, headerLightIcon, headerLightText, headerPickerText, headerTabActive, headerTabActiveText, iconActive, inlineIcon, inlineOutline, inlineText, inputActive, introSectionActive, iv_blockQuoteLine, iv_header, iv_textLink, iv_textMarkedLink, messageAuthor, messageVerticalLine, notification, notificationPlayer, online, passcodeIcon, playerButtonActive, playerCoverIcon, profileSectionActive, profileSectionActiveContent, progress, promo, sectionedScrollBarActive, seekDone, sliderActive, snackbarUpdateAction, textLink, textNeutral, textSearchQueryHighlight, textSecure, ticks, ticksRead, togglerActive, togglerPositive, tooltip_textLink, videoSliderActive, waveformActive, icon, background_icon, chatListIcon"
  private const val accentsDarker = "bubble_messageSelectionNoWallpaper, attachPhoto, attachFile, attachLocation, attachContact, attachInlineBot, introSection"
  private const val surfaceLight = "headerLightBackground, fillingPressed, overlayFilling, iv_textCodeBackground, seekEmpty"
  private const val surfaceLighter = "chatKeyboardButton, circleButtonOverlay, fileAttach, iv_textCodeBackgroundPressed, headerBarCallActive, playerCoverPlaceholder, messageSwipeBackground"
  private const val surfaceLightest = "sliderInactive, controlInactive, waveformInactive, bubbleOut_chatVerticalLine, bubbleOut_messageAuthor, bubbleOut_time, headerBarCallIncoming, bubbleOut_ticks, bubbleOut_ticksRead, seekReady, tooltip_outline"
  
  fun generateFileContent(ctx: Context) = buildString {
    appendMeta(ctx)
    appendProps()

    // - generic
    appendColors(backgrounds, ContextCompat.getColor(ctx, R.color.system_neutral1_900))
    appendColors(backgrounds2, ContextCompat.getColor(ctx, R.color.system_neutral2_800))
    appendColors(surfaceLight, SurfaceColors.SURFACE_3, ctx)
    appendColors(surfaceLighter, SurfaceColors.SURFACE_4, ctx)
    appendColors(surfaceLightest, SurfaceColors.SURFACE_5, ctx)

    appendColors(primaryText, MaterialColors.getColor(ctx, R.attr.colorOnSurface, Color.TRANSPARENT))
    appendColors(secondaryText, ColorUtils.setAlphaComponent(MaterialColors.getColor(ctx, R.attr.colorOnSurface, Color.TRANSPARENT), (0.38 * 255).toInt()))

    appendColors(accents, ContextCompat.getColor(ctx, R.color.system_accent1_100))
    appendColors(accentsDarker, ContextCompat.getColor(ctx, R.color.system_accent1_500))

    // - specific
    appendColors("tooltip", ColorUtils.setAlphaComponent(SurfaceColors.SURFACE_1.getColor(ctx), 220))
    appendColors("textLinkPressHighlight",ColorUtils.setAlphaComponent(MaterialColors.getColor(ctx, R.attr.colorPrimary, Color.TRANSPARENT), (0.25 * 255).toInt()))
    appendColors("togglerActiveBackground, togglerPositiveBackground", ColorUtils.setAlphaComponent(MaterialColors.getColor(ctx, R.attr.colorPrimary, Color.TRANSPARENT), (0.5 * 255).toInt()))
    appendColors("bubbleOut_text, bubbleOut_inlineOutline, bubbleOut_inlineText, bubbleOut_inlineIcon", MaterialColors.getColor(ctx, R.attr.colorOnPrimary, Color.TRANSPARENT))
    appendColors("bubbleOut_textLink, bubbleOut_waveformActive", ColorUtils.blendARGB(MaterialColors.getColor(ctx, R.attr.colorOnPrimary, Color.TRANSPARENT), MaterialColors.getColor(ctx, R.attr.colorPrimary, Color.TRANSPARENT), 0.25f))
    appendColors("bubbleOut_waveformInactive", ColorUtils.blendARGB(MaterialColors.getColor(ctx, R.attr.colorOnPrimary, Color.TRANSPARENT), MaterialColors.getColor(ctx, R.attr.colorPrimary, Color.TRANSPARENT), 0.5f))
    // EOF
    appendLine()
  }

  private fun StringBuilder.appendColors(values: String, color: SurfaceColors, ctx: Context) = appendColors(values, color.tgxHex(ctx))
  private fun StringBuilder.appendColors(values: String, color: Int) = appendColors(values, color.formatTgxHex())
  private fun StringBuilder.appendColors(values: String, color: String) = appendLine("$values: $color")

  private fun StringBuilder.appendMeta(ctx: Context) = apply {
    appendLine("!")
    appendLine("name: \"${ctx.resources.getString(R.string.app_name)}\"")
    appendLine("author: \"Jamal2367\"")
  }

  private fun StringBuilder.appendProps() = apply {
    appendLine("@")
    appendLine("parentTheme: 2")
    appendLine("shadowDepth: 0")
    appendLine("#")
  }

  private fun SurfaceColors.tgxHex(ctx: Context) = getColor(ctx).formatTgxHex()

  private fun Int.formatTgxHex() = "%X".format(this).let {
    "${it.drop(2)}${it.take(2)}"
  }
}