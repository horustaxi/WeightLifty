package etchee.com.weightlifty.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by rikutoechigoya on 2017/03/24.
 */

public final class DataContract {

    //universal declarations
    public static final String CONTENT_AUTHORITY = "etchee.com.weightlifty";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //Specific URI addresses
    public static final String PATH_CALENDAR = "calendar";
    public static final String PATH_EVENT_TYPE = "event_type";
    public static final String PATH_EVENT = "event";

    //private, contract cannot be instantiated
    private DataContract() {

    }

    public static final class GlobalConstants {

        //When an item in listActivity is clicked, pass the item ID
        public static final String SUB_ID = "item_sub_id";
        //From ChooseEventActivity, contentValues will be passed.
        public static final String CONTENT_VALUES = "contentValues";

        //in the inner class in EditEventActivity, "QueryEventName", id for making a loader.
        public static final int QUERY_EVENT_NAME = 0;
        public static final int QUERY_EVENT_TYPE = 2;
        public static final int QUERY_EVENT_ID = 4;

        public static final String PASS_EVENT_STRING = "eventStringPassed";
    }

    public static final class CalendarEntry implements BaseColumns {

        //content URI for this table
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_CALENDAR).build();
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CALENDAR;

        public static final String TABLE_NAME = "table_calendar";
        public static final String _ID = BaseColumns._ID;

        //and the columns
        public static final String COLUMN_DATE = "table_calendar_date";
        public static final String COLUMN_EVENT_IDs = "table_calendar_event_id";
        public static final String COLUMN_DAY_TAG = "table_calendar_day_note";
    }

    public static final class EventEntry implements BaseColumns {

        //content URI for this table
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_EVENT).build();

        public static final String TABLE_NAME = "table_event";
        public static final String _ID = BaseColumns._ID;

        //and the columns
        public static final String COLUMN_SUB_ID = "table_event_sub_id";
        public static final String COLUMN_DATE = "table_event_date";
        public static final String COLUMN_EVENT_ID = "table_event_event_id";
        public static final String COLUMN_SET_COUNT = "table_event_set_count";
        public static final String COLUMN_REP_SEQUENCE = "table_event_rep_sequence";
        public static final String COLUMN_WEIGHT_SEQUENCE = "table_event_weight_sequence";

    }


    public static final class EventTypeEntry implements BaseColumns {

        //content URI for this table
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_EVENT_TYPE).build();

        public static final String TABLE_NAME = "table_eventType";
        public static final String _ID = BaseColumns._ID;

        //and the columns
        public static final String COLUMN_EVENT_NAME = "table_eventType_event_name";
    }
}
