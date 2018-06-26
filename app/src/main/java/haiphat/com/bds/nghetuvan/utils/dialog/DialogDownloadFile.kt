package haiphat.com.bds.nghetuvan.utils.dialog

import android.app.Activity
import android.app.Dialog
import android.app.DownloadManager
import android.content.Context
import android.databinding.DataBindingUtil
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import haiphat.com.bds.nghetuvan.R
import haiphat.com.bds.nghetuvan.databinding.DialogDownloadFileBinding
import java.io.File
import java.text.NumberFormat

/**
 * Created by HUONG HA^P on 6/26/2018.
 */
class DialogDownloadFile(var activity: Activity?, var fullUrl: String?, var fileName: String?) : Dialog(activity) {

    private var bindingDocumentDownload: DialogDownloadFileBinding? = null
    private var downloadThread: Thread? = null
    private var downloadManager: DownloadManager? = null
    private var downloadId: Long? = 0
    private var isDownloaded = false
    private var outputFilePath: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDocumentDownload = DataBindingUtil.inflate(layoutInflater, R.layout.dialog_download_file, null, false)
        setContentView(bindingDocumentDownload?.root)
        bindingDocumentDownload?.tvFileName?.text = fileName
        bindingDocumentDownload?.tvCancel?.setOnClickListener {
            cancelDownload()
            if (isShowing) {
                dismiss()
            }
        }
        startDownload()
    }

    private fun startDownload() {
        if (TextUtils.isEmpty(fullUrl) || TextUtils.isEmpty(fileName)) {
            return
        }
        val request = DownloadManager.Request(Uri.parse(fullUrl))
        request.setTitle(fileName)
        request.allowScanningByMediaScanner()
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
        val mDestinationUri = Uri.withAppendedPath(Uri.fromFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)), fileName)
        val destinationFile = File(mDestinationUri.path)
        if (destinationFile.exists()) {
            destinationFile.delete()
        }
        request.setDestinationUri(mDestinationUri)
        downloadManager = activity?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager?
        downloadId = downloadManager?.enqueue(request)
        downloadThread = Thread(Runnable {
            var downloading = true
            while (downloading && !Thread.interrupted()) {
                try {
                    val q = DownloadManager.Query()
                    downloadId?.let { q.setFilterById(it) }

                    val cursor = downloadManager?.query(q)
                    cursor?.moveToFirst()
                    val downloadedBytes = cursor?.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR))
                    val totalBytes = cursor?.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES))
                    val downloadStatus = cursor?.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                    when (downloadStatus) {
                        DownloadManager.STATUS_FAILED -> {
                            downloading = false
                            cancelDownload()
                        }
                        DownloadManager.STATUS_SUCCESSFUL -> {
                            downloading = false
                            onAbort()
                        }
                    }
                    var progressValue: Float
                    if (totalBytes!! < 0f || downloadedBytes!! < 0) {
                        progressValue = 0f
                    } else {
                        progressValue = downloadedBytes?.toFloat() / totalBytes?.toFloat()
                    }
                    if (progressValue == 1f) {
                        outputFilePath = cursor?.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI))
                    }
                    Handler(Looper.getMainLooper()).post(Runnable {
                        if (bindingDocumentDownload == null) {
                            return@Runnable
                        }
                        if (downloadStatus == DownloadManager.STATUS_FAILED) {
//                            onFailed()
                            closeDialog()
                        } else {
                            val numberFormat = NumberFormat.getPercentInstance()
                            bindingDocumentDownload?.tvPercent?.text = numberFormat.format(progressValue.toDouble())
                            bindingDocumentDownload?.pbDownloadProgress?.progress = (progressValue * 100).toInt()
                            if (progressValue == 1f && !isDownloaded) {
//                                onViewFile(outputFilePath)
                                isDownloaded = true
                                onAbort()
                                closeDialog()
                            }
                        }
                    })
                    cursor?.close()
                } catch (ex: Exception) {
                    ex.printStackTrace()
                    downloading = false
                    onAbort()
                }

            }
        })
        downloadThread?.start()
    }


    private fun cancelDownload() {
        onAbort()
        if (downloadManager != null) {
            downloadId?.let { downloadManager?.remove(it) }
        }
    }

    private fun onAbort() {
        downloadThread?.let {
            it.interrupt()
        }

    }

    private fun closeDialog() {
        if (!isShowing) {
            return
        }
        dismiss()
        release()
    }

    private fun release() {
        bindingDocumentDownload = null
        downloadManager = null
        downloadThread = null
    }

}