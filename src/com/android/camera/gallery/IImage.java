/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.camera.gallery;

import android.graphics.Bitmap;
import android.net.Uri;

import java.io.InputStream;

/**
 * The interface of all images used in gallery.
 */
public interface IImage {
    static final int THUMBNAIL_TARGET_SIZE = 320;
    static final int MINI_THUMB_TARGET_SIZE = 96;

    /** Get the image list which contains this image. */
    public abstract IImageList getContainer();

    /** Get the bitmap for the full size image. */
    public abstract Bitmap fullSizeBitmap(int targetWidthOrHeight);

    /** Get the cancelable object for the bitmap of the full size image. */
    public abstract Cancelable<Bitmap> fullSizeBitmapCancelable(
            int targetWidthOrHeight);

    /** Get the input stream associated with a given full size image. */
    public abstract InputStream fullSizeImageData();
    public abstract long fullSizeImageId();
    public abstract Uri fullSizeImageUri();

    /** Get the path of the (full size) image data. */
    public abstract String getDataPath();

    // Get/Set the title of the image
    public abstract void setTitle(String name);
    public abstract String getTitle();

    // Get metadata of the image
    public abstract long getDateTaken();
    public abstract String getMimeType();
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract String getDisplayName();

    // Get property of the image
    public abstract boolean isReadonly();
    public abstract boolean isDrm();

    // Get the bitmap/uri of the medium thumbnail
    public abstract Bitmap thumbBitmap();
    public abstract Uri thumbUri();

    // Get the bitmap of the mini thumbnail.
    public abstract Bitmap miniThumbBitmap();

    // Get the row number for this image in the database table.
    public abstract int getRow();

    // Rotate the image
    public abstract boolean rotateImageBy(int degrees);

    // This is called if the image is removed.
    public abstract void onRemove();

}