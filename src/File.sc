;;; Sierra Script 1.0 - (do not remove this comment)
(script# 993)
(include sci.sh)
(use Obj)


(class File of Obj
	(properties
		handle 0
	)
	
	(method (dispose)
		(self close:)
		(super dispose:)
	)
	
	(method (showStr param1)
		(Format param1 993 0 name)
	)
	
	(method (open param1)
		(= handle
			(switch argc
				(0 (FileIO fiOPEN name 0))
				(1 (FileIO fiOPEN name param1))
				(else  0)
			)
		)
		(if (== handle -1) (= handle 0))
		(return (if handle self else 0))
	)
	
	(method (readString param1 param2)
		(if (!= argc 2) (return 0))
		(if (not handle) (self open: 1))
		(return
			(if handle
				(FileIO fiREAD_STRING param1 param2 handle)
			else
				0
			)
		)
	)
	
	(method (writeString param1 &tmp temp0)
		(if (not handle) (self open:))
		(if handle
			(= temp0 0)
			(while (< temp0 argc)
				(FileIO fiWRITE_STRING handle [param1 temp0])
				(++ temp0)
			)
		)
	)
	
	(method (write param1 param2 &tmp temp0)
		(if (not handle) (self open:))
		(return (if handle (FileIO fiWRITE handle param1 param2) else 0))
	)
	
	(method (read param1 param2)
		(if (!= argc 2) (return 0))
		(if (not handle) (self open: 1))
		(return (if handle (FileIO fiREAD handle param1 param2) else 0))
	)
	
	(method (seek param1 param2 &tmp temp0)
		(= temp0 (if (>= argc 2) param2 else 0))
		(if (not handle) (self open: 1))
		(return (if handle (FileIO fiSEEK handle param1 temp0) else 0))
	)
	
	(method (close)
		(if handle (FileIO fiCLOSE handle) (= handle 0))
	)
	
	(method (delete)
		(if handle (self close:))
		(FileIO fiUNLINK name)
	)
)
