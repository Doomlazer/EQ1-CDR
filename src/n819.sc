;;; Sierra Script 1.0 - (do not remove this comment)
(script# 819)
(include sci.sh)
(use Main)
(use Smopper)
(use StopWalk)
(use Grooper)
(use Obj)

(public
	proc819_3 3
	proc819_4 4
	proc819_5 5
	proc819_6 6
	proc819_7 7
	proc819_8 8
	proc819_9 9
)

(procedure (proc819_3 param1 &tmp temp0)
	(= temp0 (proc819_5 param1))
	(= [global152 (/ param1 16)]
		(|
			[global152 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
	(return temp0)
)

(procedure (proc819_4 param1 &tmp temp0)
	(= temp0 (proc819_5 param1))
	(= [global152 (/ param1 16)]
		(&
			[global152 (/ param1 16)]
			(~ (>> $8000 (mod param1 16)))
		)
	)
	(return temp0)
)

(procedure (proc819_5 param1)
	(return
		(&
			[global152 (/ param1 16)]
			(>> $8000 (mod param1 16))
		)
	)
)

(procedure (proc819_6 param1 param2 param3 &tmp temp0)
	(= temp0 0)
	(if (> argc 0)
		(gEgo loop: param1)
		(if (> argc 1)
			(gEgo view: param2)
			(if (> argc 2) (= temp0 param3))
		)
	)
	(if (not temp0) (= temp0 801))
	(gEgo
		signal: 4096
		z: 0
		setLoop: -1
		setLoop: gStopGroop
		setPri: -1
		setMotion: 0
		illegalBits: 0
		ignoreActors: 0
		ignoreHorizon: 1
		setStep: 4 3
		moveSpeed: global252
		cycleSpeed:
			(*
				global252
				(if (proc999_5 gNewRoomNumber 320 321 322 335) 2 else 1)
			)
	)
	(cond 
		((proc999_5 gNumber 380 400 381) (gEgo view: 800 setCycle: StopWalk temp0 setStep: 2 2))
		((proc999_5 gNumber 320 321 322 335)
			(gEgo
				view: 822
				setCycle: Smopper 818 668 0 (* global252 2)
			)
		)
		(else
			(gEgo
				view: 802
				ignoreHorizon: 0
				setCycle: Smopper 805 814 815 (* global252 2)
			)
		)
	)
)

(procedure (proc819_7)
	(gDelph
		signal: 4096
		view: 831
		z: 100
		lookStr: 0
		setLoop: -1
		setLoop: delphStopGroop
		setPri: -1
		setMotion: 0
		illegalBits: 0
		ignoreActors: 1
		ignoreHorizon: 1
		setStep: 5 4
		moveSpeed: 4
		cycleSpeed: 8
		setCycle: Smopper 836 0 0 20
	)
)

(procedure (proc819_8 param1 param2)
	(if (< param1 0) (= param1 0))
	(if (> param1 255) (= param1 255))
	(if (< param2 0) (= param2 0))
	(if (> param2 15) (= param2 15))
	(return (if (> global102 16) param1 else param2))
)

(procedure (proc819_9 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3)
	(= temp3 0)
	(if (IsObject param2)
		(= temp1 (param2 x?))
		(= temp2 (param2 y?))
		(if (== argc 3) (= temp3 param3))
	else
		(= temp1 param2)
		(= temp2 param3)
		(if (== argc 4) (= temp3 param4))
	)
	(= temp0
		(GetAngle (param1 x?) (param1 y?) temp1 temp2)
	)
	(param1
		setHeading: temp0 (if (IsObject temp3) temp3 else 0)
	)
)

(instance delphStopGroop of Grooper
	(properties)
)
