# share-as-vxtwitter

I don't know and don't care how it works. I vibe coded it in 10 minutes with literally zero android edvelopment knowlage and experience. No feature updates are planned, that's the final app.

This is a simple app, that will show in your "Share" menu, and just will replace x.com domain with vxtwitter.com domain in URL you share. You click the app, and it opens the same "Share" menu with the new link.

DEMO: https://vxtwitter.com/bielarusajed/status/2005302880417595540

Download the APK from the [latest release](https://github.com/bielarusajed/share-as-vxtwitter/releases/latest). No GitHub sign-in is required. The app requires Android 7.0 or newer.

## Releases

Publishing a GitHub release automatically builds a signed release APK and attaches it, along with a SHA-256 checksum, to that release. The release tag must match `versionName` in `app/build.gradle.kts`, prefixed with `v`, for example `v1.0.0`. For each new version, update `versionName` and increase `versionCode` before creating the tag and publishing the release.

To rebuild assets for an existing release, manually run the **Release APK** workflow from `main` and enter its release tag. This builds the code at that tag and replaces the APK and checksum on the existing release.

The release workflow uses two repository Actions secrets:

- `ANDROID_KEYSTORE_BASE64`: the base64-encoded release keystore, with a key named `release`.
- `ANDROID_KEYSTORE_PASSWORD`: the password for both the keystore and its key.

Keep a private backup of the keystore and password. Future APKs must use the same signing key so Android can install them as updates. If you installed an older debug APK from Actions, uninstall it before installing the release APK.
