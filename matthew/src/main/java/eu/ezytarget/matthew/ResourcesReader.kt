package eu.ezytarget.matthew

import android.content.res.Resources
import android.util.Log
import androidx.annotation.ArrayRes


internal class ResourcesReader {

    fun getArrayOfIntArrays(resources: Resources, @ArrayRes resourceID: Int): Array<Array<Int>> {
        val arrayOfArrayIDs = resources.obtainTypedArray(resourceID)
        val numOfArrays = arrayOfArrayIDs.length()
        val listOfIntArrays =  ArrayList<Array<Int>>()
        for (idIndex in 0 until numOfArrays) {
            val arrayID = arrayOfArrayIDs.getResourceId(idIndex, FALLBACK_RESOURCE_ID)
            if (arrayID == FALLBACK_RESOURCE_ID) {
                Log.e(tag, "No resource ID found at position $idIndex in resource $resourceID.")
                continue
            }

            val intArray = resources.getIntArray(arrayID).toTypedArray()
            listOfIntArrays.add(intArray)
        }

        arrayOfArrayIDs.recycle()

        return listOfIntArrays.toTypedArray()
    }

    companion object {
        val tag = ResourcesReader::class.java.simpleName
        private const val FALLBACK_RESOURCE_ID = -1
    }
}