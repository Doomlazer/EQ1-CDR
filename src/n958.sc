;;; Sierra Script 1.0 - (do not remove this comment)
(script# 958)
(include sci.sh)

(public
	proc958_0 0
)

(procedure (proc958_0 param1 param2 &tmp temp0 temp1)
	(= argc (- argc 2))
	(= temp0 0)
	(while (<= temp0 argc)
		(= temp1 [param2 temp0])
		(if param1
			(Load param1 temp1)
		else
			(DisposeScript temp1)
		)
		(++ temp0)
	)
	(DisposeScript 958)
)
