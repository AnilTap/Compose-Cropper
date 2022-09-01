package com.smarttoolfactory.cropper

import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.smarttoolfactory.cropper.model.AspectRatio

/**
 * Contains the default values used by [ImageCropper]
 */
object CropDefaults {

    fun properties(
        cropType: CropType = CropType.Dynamic,
        handleSize: Dp = 40.dp,
        minOverlaySize: Dp = 100.dp,
        minZoom: Float = 1f,
        maxZoom: Float = 5f,
        aspectRatio: AspectRatio = AspectRatio.Unspecified,
        fling: Boolean = false,
        zoomable: Boolean = true,
        pannable: Boolean = true,
        rotatable: Boolean = false
    ): CropProperties {
        return CropProperties(
            cropType = cropType,
            handleSize = handleSize,
            minOverlaySize = minOverlaySize,
            minZoom = minZoom,
            maxZoom = maxZoom,
            aspectRatio = aspectRatio,
            fling = fling,
            zoomable = zoomable,
            pannable = pannable,
            rotatable = rotatable
        )
    }

    fun style(
        drawOverlay: Boolean = true,
        drawGrid: Boolean = true,
        strokeWidth: Dp = 2.dp,
        overlayColor: Color = Color.White
    ): CropStyle {
        return CropStyle(
            drawOverlay = drawOverlay,
            drawGrid = drawGrid,
            strokeWidth = strokeWidth,
            overlayColor = overlayColor
        )
    }
}

/**
 * Data class for selecting cropper properties. Fields of this class control inner work
 * of [CropState] while some such as [cropType], [aspectRatio], [handleSize], and [minOverlaySize]
 * is shared between ui and state.
 */
@Immutable
data class CropProperties internal constructor(
    val cropType: CropType = CropType.Dynamic,
    val handleSize: Dp = 40.dp,
    val minOverlaySize: Dp = 100.dp,
    val minZoom: Float = 1f,
    val maxZoom: Float = 5f,
    val aspectRatio: AspectRatio = AspectRatio.Unspecified,
    val fling: Boolean = false,
    val zoomable: Boolean = true,
    val pannable: Boolean = true,
    val rotatable: Boolean = false
)

/**
 * Data class for cropper styling only. None of the properties of this class is used
 * by [CropState] or [Modifier.crop]
 */
@Immutable
data class CropStyle internal constructor(
    val drawOverlay: Boolean = true,
    val drawGrid: Boolean = true,
    val strokeWidth: Dp = 2.dp,
    val overlayColor: Color = Color.White
)
